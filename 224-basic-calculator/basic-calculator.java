class Solution {
    public int priority(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public boolean isUnaryMinus(String s, int i) {
        int j = i - 1;

        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }

        if (j < 0) return true;

        char prev = s.charAt(j);

        return prev == '(' ||
               prev == '+' ||
               prev == '-' ||
               prev == '*' ||
               prev == '/' ||
               prev == '^';
    }

    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    ans.append(s.charAt(i));
                    i++;
                }
                ans.append(' ');
                continue;
            }

            if (c == '(') {
                st.push(c);
            } 
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop()).append(' ');
                }

                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            else {
                if (c == '-' && isUnaryMinus(s, i)) {
                    ans.append("0 ");
                }

                if (c == '^') {
                    while (!st.isEmpty()
                            && st.peek() != '('
                            && priority(c) < priority(st.peek())) {
                        ans.append(st.pop()).append(' ');
                    }
                } 
                else {
                    while (!st.isEmpty()
                            && st.peek() != '('
                            && priority(c) <= priority(st.peek())) {
                        ans.append(st.pop()).append(' ');
                    }
                }

                st.push(c);
            }

            i++;
        }

        while (!st.isEmpty()) {
            ans.append(st.pop()).append(' ');
        }

        return ans.toString().trim();
    }

    public int postfixEval(String s) {
        Stack<Long> st = new Stack<>();

        if (s.isEmpty()) {
            return 0;
        }

        String[] tokens = s.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                st.push(Long.parseLong(token));
            } 
            else {
                long b = st.pop();
                long a = st.pop();

                switch (token.charAt(0)) {
                    case '+':
                        st.push(a + b);
                        break;

                    case '-':
                        st.push(a - b);
                        break;

                    case '*':
                        st.push(a * b);
                        break;

                    case '/':
                        st.push(a / b);
                        break;

                    case '^':
                        st.push((long) Math.pow(a, b));
                        break;
                }
            }
        }

        return st.pop().intValue();
    }

    public int calculate(String s) {
        return postfixEval(infixToPostfix(s));
    }
}