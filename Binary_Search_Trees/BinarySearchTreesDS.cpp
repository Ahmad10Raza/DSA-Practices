#include <iostream>

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

class BinarySearchTree {
private:
    Node* root;

public:
    BinarySearchTree() {
        root = nullptr;
    }

    void insert(int value) {
        root = insertRecursive(root, value);
    }

    Node* insertRecursive(Node* root, int value) {
        if (root == nullptr) {
            return new Node(value);
        }

        if (value < root->data) {
            root->left = insertRecursive(root->left, value);
        } else if (value > root->data) {
            root->right = insertRecursive(root->right, value);
        }

        return root;
    }

    bool search(int value) {
        return searchRecursive(root, value);
    }

    bool searchRecursive(Node* root, int value) {
        if (root == nullptr) {
            return false;
        }

        if (value == root->data) {
            return true;
        } else if (value < root->data) {
            return searchRecursive(root->left, value);
        } else {
            return searchRecursive(root->right, value);
        }
    }

    void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    void inorderTraversalRecursive(Node* root) {
        if (root != nullptr) {
            inorderTraversalRecursive(root->left);
            std::cout << root->data << " ";
            inorderTraversalRecursive(root->right);
        }
    }
};

int main() {
    BinarySearchTree bst;

    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);

    std::cout << "Inorder Traversal: ";
    bst.inorderTraversal();
    std::cout << std::endl;

    int searchValue = 40;
    if (bst.search(searchValue)) {
        std::cout << searchValue << " found in the tree." << std::endl;
    } else {
        std::cout << searchValue << " not found in the tree." << std::endl;
    }

    return 0;
}