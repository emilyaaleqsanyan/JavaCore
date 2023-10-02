package homework.bracechecker;

public class BraceChecker {
    private String text;
    Stack mystack = new Stack();
    Stack myStackForIndex = new Stack();
    char last, c;
    int count = 0;


    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                mystack.push(c);
                myStackForIndex.push(i);
                count++;
                continue;
            }
            switch (c) {
                case ')':
                    if (count <= 0) {
                        System.out.println("Error: not open but closed " + c + " at " + i);
                        break;

                    }
                    last = (char) mystack.pop();
                    if (last != '(' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    myStackForIndex.pop();
                    break;

                case '}':
                    if (count <= 0) {
                        System.out.println("Error: not open but closed " + c + " at " + i);
                        break;

                    }
                    last = (char) mystack.pop();
                    if (last != '{' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    myStackForIndex.pop();
                    break;
                case ']':
                    if (count <=  0) {
                        System.out.println("Error: not open but closed " + c + " at " + i);
                        break;

                    }
                    last = (char) mystack.pop();
                    if (last != '[' && count > 0) {
                        System.out.println("Error:opened " + last + " but closed " + c + " at " + i);
                    }
                    count--;
                    myStackForIndex.pop();
                    break;
            }
        }
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("Error:opened " + (char) mystack.pop() + " but not closed at " + myStackForIndex.pop());
            }
        }

    }

}