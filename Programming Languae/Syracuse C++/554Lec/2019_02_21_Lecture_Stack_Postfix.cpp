//Application for stack.
//Create a tree structure for an input postfix expression such as 34*75+*  i.e., (3*4)*(7+5)
//and then evaluate the expression.
//Assume values are of 1 digit (such as 3, 4, 7, 5 in the above example) and that
//only operators *, /, +, and - are considered.
//

#include <iostream>
#include <stack>
#include <string>

using namespace std;

class node {
public:
	char value;
	node * l_child;
	node * r_child;
	node() { l_child = r_child = nullptr; }
	node(char c) { value = c; l_child = r_child = nullptr; }
};

class tree {
public:
	node * root;
	tree() { root = nullptr; }
	void construct(string &str);
	int evaluate(node * p);
};
void tree::construct(string &str) {
	node * p = nullptr;
	stack<node *> S;
	for (size_t i = 0; i<str.length(); i++) {
		p = new node(str.at(i));
		if (str.at(i) == '*' || str.at(i) == '/' ||
			str.at(i) == '+' || str.at(i) == '-') {
			p->r_child = S.top();
			S.pop();
			p->l_child = S.top();
			S.pop();
			S.push(p);
		}
		else S.push(p);
	}
	root = p;
}


int tree::evaluate(node * p) {
	if (p->value != '*' && p->value != '/'&&
		p->value != '+'&& p->value != '-')  return (p->value - '0');
	else {
		switch (p->value) {
		case '*': return evaluate(p->l_child) * evaluate(p->r_child);
		case '/': return evaluate(p->l_child) / evaluate(p->r_child);
		case '+': return evaluate(p->l_child) + evaluate(p->r_child);
		case '-': return evaluate(p->l_child) - evaluate(p->r_child);
		}
	}
}
int main() {

	string str;
	cin >> str; //assume value are of 1 digit
	tree T;
	T.construct(str);
	cout << T.evaluate(T.root) << endl;

	getchar();
	getchar();
	return 0;
}
//for stack: size(), empty(), top(), pop(), push(item)
//for queue: size(), empty(), front(), back(), pop(), push(item)
//NO iterator for stack and queue


//*
//sample input 34*75+*
//output will be 144
