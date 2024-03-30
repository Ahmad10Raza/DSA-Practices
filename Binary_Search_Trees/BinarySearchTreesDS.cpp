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


    // function to construct Balanced BST from sorted array

    // Input: 1 2 3 4 5 6 7
    // Output: 4 2 6 1 3 5 7 (Inorder traversal of the constructed BST)
    // Tree:        4
    //            /     \
    //          2         6
    //         /  \     /  \
    //       1   3     5    7

    Node* sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return nullptr;
        }

        int mid = (start + end) / 2;
        Node* root = new Node(arr[mid]);

        root->left = sortedArrayToBST(arr, start, mid - 1);
        root->right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    Node* sortedArrayToBST(int arr[], int n) {
       
        return sortedArrayToBST(arr, 0, n-1);
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

    // int searchValue = 40;
    // if (bst.search(searchValue)) {
    //     std::cout << searchValue << " found in the tree." << std::endl;
    // } else {
    //     std::cout << searchValue << " not found in the tree." << std::endl;
    // }


    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    Node* root = bst.sortedArrayToBST(arr,n);
    bst.inorderTraversalRecursive(root);






    return 0;
}