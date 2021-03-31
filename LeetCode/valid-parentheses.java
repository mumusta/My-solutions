class Solution {
    public boolean isValid(String s) {
        
        Stack < Character > st = new Stack < Character > ();

        for (int i = 0; i < s.length(); i ++){

            if (st.empty()){
                st.add(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == ')'){
                
                if (st.peek() == '(')
                    st.pop();
                else return false;

                continue;
            }

            if (s.charAt(i) == '}'){

                if (st.peek() == '{')
                    st.pop();
                else return false;

                continue;
            }

            if (s.charAt(i) == ']'){

                if (st.peek() == '[')
                    st.pop();
                else return false;

                continue;
            }

            st.add(s.charAt(i));
        }

        if (st.empty())
            return true;
        else return false;
    }
}
