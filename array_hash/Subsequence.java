package array_hash;

public class Subsequence {

    public static int subSeq(String s, String t){

    int i = 0;
    int j = 0;

    while(i<s.length() && j<t.length()){
        if(s.charAt(i) == t.charAt(j)){
            j++;
        }
        i++;
    }
        /*
        *সহজ ভাষায় ব্যাখ্যা:
🔸 Step 1:

i দিয়ে s এর প্রতিটা character একে একে দেখা হচ্ছে।

🔸 Step 2:

t এর j-তম character এর সাথে মিলে কিনা চেক করা হচ্ছে:

যদি match হয় → j++
মানে t এর পরের character match করানোর চেষ্টা করবো।

যদি match না হয় → কিছু হবে না
শুধু i++ হবে, মানে s এ পরের character এ যাবো।

🔸 Step 3:

i++ সবসময় হবে, কারণ s এর পরের character দেখতে হবে।
        *
        *
        * */

        return t.length()-j;
        /*t.length() → t স্ট্রিং-এর মোট কয়টা character আছে
j → কয়টা character আমরা ইতোমধ্যে match করতে পেরেছি (subsequence হিসেবে)

তাই:*/
    }



    public static void main(String[] args){
       Subsequence  sub = new Subsequence();

       System.out.println(sub.subSeq("Coaching","Coding"));
    }

}
