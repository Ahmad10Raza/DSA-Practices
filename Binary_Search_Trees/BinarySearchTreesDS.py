class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, node, key):
        if key < node.key:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        else:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)

    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, node, key):
        if node is None or node.key == key:
            return node
        if key < node.key:
            return self._search_recursive(node.left, key)
        return self._search_recursive(node.right, key)

    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, node, key):
        if node is None:
            return node
        if key < node.key:
            node.left = self._delete_recursive(node.left, key)
        elif key > node.key:
            node.right = self._delete_recursive(node.right, key)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            min_node = self._find_min(node.right)
            node.key = min_node.key
            node.right = self._delete_recursive(node.right, min_node.key)
        return node

    def _find_min(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

    def inorder_traversal(self):
        self._inorder_recursive(self.root)

    def _inorder_recursive(self, node):
        if node is not None:
            self._inorder_recursive(node.left)
            print(node.key, end=" ")
            self._inorder_recursive(node.right)
   
   
            
            
    #  Function to check given tree is BST or not

    #  Tree:        50
    #             /     \
    #           30       70
    #          /  \     /  \
    #       20   40   60   80

    #  Output: Given tree is a BST
    
    def isBST(self, root, l = None, r = None):
        if root is None:
            return True
        if l is not None and root.key <= l.key:
            return False
        if r is not None and root.key >= r.key:
            return False
        return self.isBST(root.left, l, root) and self.isBST(root.right, root, r)
            
            
           

bst = BinarySearchTree()

# Insert nodes
bst.insert(50)
bst.insert(30)
bst.insert(20)
bst.insert(40)
bst.insert(70)
bst.insert(60)
bst.insert(80)

# Search for a node
search_key = 40
result = bst.search(search_key)
if result:
    print(f"Node with key {search_key} found!")
else:
    print(f"Node with key {search_key} not found!")

            # Delete a node
# delete_key = 30
# bst.delete(delete_key)
# print(f"Node with key {delete_key} deleted!")

# Inorder traversal
print("Inorder Traversal:")
bst.inorder_traversal()


print("\nGiven tree is a BST") if bst.isBST(bst.root) else print("Given tree is not a BST")