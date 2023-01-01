package com.mumusta.algoexpert;

public class RunLengthEncoding {

    public String runLengthEncoding(String string) {

        int count = 1;
        char c = string.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < string.length(); i ++){

            if (c == string.charAt(i))
                count ++;

            else {

                while (count > 0){

                    if (count >= 9){

                        sb.append('9');
                        sb.append(c);
                        count -= 9;
                    }

                    else {

                        sb.append(count);
                        sb.append(c);
                        count -= count;
                    }
                }

                count = 1;
                c = string.charAt(i);
            }
        }

        while (count > 0){

            if (count >= 9){

                sb.append('9');
                sb.append(c);
                count -= 9;
            }

            else {

                sb.append(count);
                sb.append(c);
                count -= count;
            }
        }

        return sb.toString();
    }
}
