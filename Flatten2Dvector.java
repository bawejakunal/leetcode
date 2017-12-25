/*
 * https://leetcode.com/problems/flatten-2d-vector/description/
 *
 * Easiest way is to form a queue and append all items in that
 * That takes O(n*2) time for constructor
 * 
 * The below approach follows lazy evaluation where one row at a
 * time is serialized
 */

public class Vector2D implements Iterator<Integer> {

    private Stack<List<Integer>> stack;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.stack = new Stack<>();
        for (int i = vec2d.size() - 1; i >= 0; i--) {
            this.stack.push(vec2d.get(i));
        }
    }

    @Override
    public Integer next() {
        this.hasNext();    // serialize if not done already
        List<Integer> top = this.stack.pop();
        return top.get(0);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !(stack.peek().size() == 1)) {
            List<Integer> top = stack.pop();
            for (int i = top.size()-1; i >= 0; i--) {
                stack.push(top.subList(i, i + 1));
            }
        }
        return !stack.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */