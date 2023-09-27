package homework.bracechecker;

public class BraceChecker {
    private String text;
    Stack mystack = new Stack();
    char last;


    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                mystack.push(c);
                continue;
            }
            switch (c) {
                case ')':
                    last = (char) mystack.pop();
                    if (last != '(') {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    break;
                case '}':
                    last = (char) mystack.pop();
                    if (last != '{') {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    break;
                case ']':
                    last = (char) mystack.pop();
                    if (last != '[') {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    break;

            }

        }


    }
}
