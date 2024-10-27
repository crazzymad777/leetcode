class Solution {
public:
    int popIt(stack<int>& s) {
        int result = s.top();
        s.pop();
        return result;
    }

    int evalRPN(vector<string>& tokens) {
        stack<int> memory;
        for (auto x : tokens) {
            if (x == "+") {
                memory.push(popIt(memory) + popIt(memory));
            } else if (x == "-") {
                int op1 = popIt(memory);
                int op2 = popIt(memory);
                memory.push(op2 - op1);
            } else if (x == "/") {
                int op1 = popIt(memory);
                int op2 = popIt(memory);
                memory.push(op2 / op1);
            } else if (x == "*") {
                memory.push(popIt(memory) * popIt(memory));
            } else {
                memory.push(stoi(x));
            }
        }
        return memory.top();
    }
};

