//operator= left ref

template <class T> void linked_list<T>::operator=(const linked_list<T> &L) { //operator= left ref
	node<T> * p;
	while (first != nullptr) {
		p = first->next;
		delete first;
		first = p;
	}
	p = L.first;
	while (p != nullptr) {
		push_back(p->value);
		p = p->next;
	}
}



template <class X> void bag<X>::operator=(const bag<X> & B) {//operator= ; left value ref
	item<X> * p1 = head, *p2;
	while (p1 != nullptr) {
		p2 = p1->next;
		delete p1;
		p1 = p2;
	}
	num_items = 0;
	head = tail = nullptr;
	if (B.num_items == 0) return;
	p1 = B.head;
	while (p1 != nullptr) {
		push_back(p1->data);
		p1 = p1->next;
		num_items++;
	}
}


int a = 7/3;
cout<<"Testing "<< a <<endl;
