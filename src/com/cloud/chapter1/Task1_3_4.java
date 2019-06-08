package com.cloud.chapter1;

import MyDataStructure.MyStack;

public class Task1_3_4 {

	public static void main(String[] args) {
		String[] s = {"[", "(",   "]"};
		boolean a = Parentheses.f(s);
		System.out.println(a);
	}
	
}

class Parentheses {
	public static boolean f(String[] a) {
		MyStack<String> stack = new MyStack<String>();
		for (String s : a) {
			if (s.equals("(") || s.equals("[") || s.equals("{")) {
				stack.push(s);
			} else {
				String ss = stack.pop();
				if (ss == null) {
					return false;
				}
				if (s.equals(")")) {
					if (!ss.equals("(")) {
						return false;
					}
				}
				if (s.equals("]")) {
					if (!ss.equals("[")) {
						return false;
					}
				}
				if (s.equals("}")) {
					if (!ss.equals("{")) {
						return false;
					}
				}
			}
		}
		if (stack.pop() == null) {
			return true;
		} else {
			return false;
		}
	}
}
