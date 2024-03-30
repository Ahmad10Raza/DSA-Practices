#include <iostream>
#include <vector>

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


    // Function to convert BST to Blanced BST

    // Input: 1 2 3 4 5 6 7
    // Output: 4 2 6 1 3 5 7 (Inorder traversal of the constructed BST)
    // Tree:        4
    //            /     \
    //          2         6
    //         /  \     /  \
    //       1   3     5    7

    void storeBSTNodes(Node* root, std::vector<Node*> &nodes) {
        if (root == nullptr) {
            return;
        }

        storeBSTNodes(root->left, nodes);
        nodes.push_back(root);
        storeBSTNodes(root->right, nodes);
    }

    Node* buildTreeUtil(std::vector<Node*> &nodes, int start, int end) {
        if (start > end) {
            return nullptr;
        }

        int mid = (start + end) / 2;
        Node* root = nodes[mid];

        root->left = buildTreeUtil(nodes, start, mid - 1);
        root->right = buildTreeUtil(nodes, mid + 1, end);

        return root;
    }

    Node* buildTree(Node* root) {
        std::vector<Node*> nodes;
        storeBSTNodes(root, nodes);

        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }



    // Function to  Find LCA  of 2 nodes in a BST

    // LCA means Lowest Common Ancestor 


    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 20, 40
    // Output: 30


    Node* LCA(Node* root, int n1, int n2) {
        if (root == nullptr) {
            return nullptr;
        }

        if (root->data > n1 && root->data > n2) {
            return LCA(root->left, n1, n2);
        }

        if (root->data < n1 && root->data < n2) {
            return LCA(root->right, n1, n2);
        }

        return root;
    }

    Node* LCA(int n1, int n2) {
        return LCA(root, n1, n2);
    }



    // Function to find the Kth smallest element in a BST

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 3
    // Output: 40

    int KthSmallest(Node* root, int &k) {
        if (root == nullptr) {
            return -1;
        }

        int left = KthSmallest(root->left, k);
        if (left != -1) {
            return left;
        }

        k--;
        if (k == 0) {
            return root->data;
        }

        return KthSmallest(root->right, k);
    }

    int KthSmallest(int k) {
        return KthSmallest(root, k);
    }


    // Function to count node in given range in a BST

//     Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

// The values smaller than root go to the left side
// The values greater and equal to the root go to the right side

// Input:
//       10
//      /  \
//     5    50
//    /    /  \
//   1    40  100
// l = 5, h = 45
// Output: 3
// Explanation: 5 10 40 are the node in the
// range

    int getCountOfNode(Node* root, int l, int h) {
        if (root == nullptr) {
            return 0;
        }

        if (root->data >= l && root->data <= h) {
            return 1 + getCountOfNode(root->left, l, h) + getCountOfNode(root->right, l, h);
        } else if (root->data < l) {
            return getCountOfNode(root->right, l, h);
        } else {
            return getCountOfNode(root->left, l, h);
        }
    }

    int getCountOfNode(int l, int h) {
        return getCountOfNode(root, l, h);
    }

    // Function to find the sum of all nodes in a BST

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Output: 250

    int sumOfNodes(Node* root) {
        if (root == nullptr) {
            return 0;
        }

        return root->data + sumOfNodes(root->left) + sumOfNodes(root->right);
    }

    int sumOfNodes() {
        return sumOfNodes(root);
    }

    // Function to find the sum of all nodes in a BST in a given range

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 20, 70
    // Output: 200

    int sumOfNodesInRange(Node* root, int l, int h) {
        if (root == nullptr) {
            return 0;
        }

        if (root->data >= l && root->data <= h) {
            return root->data + sumOfNodesInRange(root->left, l, h) + sumOfNodesInRange(root->right, l, h);
        } else if (root->data < l) {
            return sumOfNodesInRange(root->right, l, h);
        } else {
            return sumOfNodesInRange(root->left, l, h);
        }
    }

    int sumOfNodesInRange(int l, int h) {
        return sumOfNodesInRange(root, l, h);
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