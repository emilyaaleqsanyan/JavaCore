package homework.bracechecker;

public class BraceChecker {
    private String text;
    Stack mystack = new Stack();
      char last, c;
    int count = 0;


    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
             this.c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                mystack.push(c);
                count++;
                continue;
            }
            switch (c) {
                case ')':
                    last = (char) mystack.pop();
                    if (last != '(' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    break;
                case '}':
                    last = (char) mystack.pop();
                    if (last != '{' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    break;
                case ']':
                    last = (char) mystack.pop();
                    if (last != '[' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    break;
            }
        }
        if (count > 0) {
            System.out.println("Error:opened " + last + " but not clsed" );
        } else if (count < 0) {
            System.out.println("Error: not open but closed " + c );

        }

    }
}