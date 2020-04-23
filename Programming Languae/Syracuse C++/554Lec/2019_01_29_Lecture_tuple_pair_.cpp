//tuple pair
#include <iostream>
#include <tuple>
using namespace std;

tuple<int, int, char, char> f1(pair<int, char> &P) {
	char c = 't';
	return make_tuple(P.first, P.first + 5, P.second, c);

}

int main() {
	int i, j;
	char c1, c2;
	pair<int, char> p1 = { 5, 'e' };
	i = get<0>(f1(p1));
	j = get<1>(f1(p1));
	c1 = get<2>(f1(p1));
	c2 = get <3>(f1(p1));

	tie(i, j,ignore, c2) = f1(p1);  //unpacking tuple into variables


	getchar();
	getchar();
	return 0;
}

