package SystemDesign;//package SystemDesign;
//
///**
// * Redis 实现一个分布式限流器
// */
//public class RedisLimit {
//
//import redis.clients.jedis.Jedis;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//    private final Jedis jedis;
//    private final String tokenKey;
//    private final int capacity;
//    private final double refillRate;
//    private final ScheduledExecutorService scheduledExecutorService;
//
//    public DistributedTokenBucketRateLimiter(Jedis jedis, String tokenKey, int capacity, double refillRate) {
//        this.jedis = jedis;
//        this.tokenKey = tokenKey;
//        this.capacity = capacity;
//        this.refillRate = refillRate;
//        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//        // 初始化令牌桶
//        initTokenBucket();
//
//        // 定时补充令牌
//        scheduleRefill();
//    }
//
//    private void initTokenBucket() {
//        jedis.set(tokenKey, String.valueOf(capacity));
//        jedis.expire(tokenKey, 1); // 设置一个短过期时间，由定时任务刷新
//    }
//
//    private void scheduleRefill() {
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            long currentTokens = Long.parseLong(jedis.get(tokenKey));
//            long refillAmount = (long) (refillRate * TimeUnit.SECONDS.toMillis(1)); // 每次补充的令牌数量
//            long newTokens = Math.min(capacity, currentTokens + refillAmount);
//
//            // 使用lua脚本来实现原子操作
//            String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then "
//                    + "redis.call('set', KEYS[1], ARGV[2]); "
//                    + "return true "
//                    + "end "
//                    + "return false";
//            Object result = jedis.eval(luaScript, Collections.singletonList(tokenKey),
//                    Arrays.asList(String.valueOf(currentTokens), String.valueOf(newTokens)));
//
//            if ((boolean) result) { // 更新令牌成功
//                jedis.expire(tokenKey, 1); // 刷新过期时间
//            }
//        }, 0, 1, TimeUnit.SECONDS); // 每秒补充一次
//    }
//
//    /**
//     * 尝试消费令牌
//     * @param tokens 需要消费的令牌数量
//     * @return 是否成功消费
//     */
//    public boolean tryConsume(int tokens) {
//        // 使用lua脚本来实现原子性的令牌扣除和判断
//        String luaScript = "if redis.call('decrby', KEYS[1], ARGV[1]) >= 0 then "
//                + "return true "
//                + "else "
//                + "redis.call('incrby', KEYS[1], ARGV[1]) "
//                + "return false "
//                + "end";
//        Object result = jedis.eval(luaScript, Collections.singletonList(tokenKey), Collections.singletonList(String.valueOf(tokens)));
//        return (boolean) result;
//    }
//
//    // 在应用关闭时，记得关闭定时任务
//    public void shutdown() {
//        scheduledExecutorService.shutdown();
//    }
//}