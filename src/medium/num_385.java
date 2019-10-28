package medium;
//没看懂
public class num_385 {
    //public NestedInteger deserialize(String s) {
    //    if(!s.contains("[")){
    //        return new NestedInteger(Integer.valueOf(s));
    //    }
    //    Stack<Character> stack = new Stack<>();
    //    Stack<NestedInteger> numStack = new Stack<>();
    //    StringBuilder b = new StringBuilder();
    //    for(char c :  s.toCharArray()){
    //        if(c=='['){
    //            stack.push(c);
    //        }else if(c == ']'){
    //            if(b.length()>0){
    //                numStack.push(new NestedInteger(Integer.valueOf(b.toString())));
    //                b = new StringBuilder();
    //                stack.push('.');//用.表示一个NestedInteger
    //            }
    //            List<NestedInteger> list= new ArrayList<>();
    //            while(true){
    //                char z = stack.pop();
    //                if(z == '.'){
    //                    list.add(0, numStack.pop());
    //                }
    //                if(z=='['){//遇到[即生成一个新的NestedInteger
    //                    break;
    //                }
    //            }
    //            if(list.size()>0){
    //                NestedInteger n = new NestedInteger();
    //                for(NestedInteger ne : list){
    //                    n.add(ne);
    //                }
    //                stack.push('.');
    //                numStack.push(n);
    //            }
    //            else{
    //                stack.push('.');
    //                numStack.push(new NestedInteger());
    //            }
    //        }else{
    //            if(c == ','){//遇到“，”，把数字保存起来
    //                if(b.length()>0){
    //                    numStack.push(new NestedInteger(Integer.valueOf(b.toString())));
    //                    b = new StringBuilder();
    //                    stack.push('.');
    //                }
    //            }else{
    //                b.append(c);
    //            }
    //        }
    //    }
    //    return numStack.pop();
    //}



}



