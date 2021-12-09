public class BinarySearch {
    Node root;
    Node checkNode;
    Node parent;

    public void addNode(Node newNode) {
        //Initially, a node is entered and it becomes root
        if (root == null) {
            root = newNode;
        }
        else {
            checkNode = root;
            //infinite loop to take the place of recursion,
            while (true) {
                parent = checkNode;
                if (newNode.key > checkNode.key) {
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
                if (newNode.key < checkNode.key) {
                    //Preventing null reference
                    parent = checkNode;
                    checkNode = checkNode.leftChild;
                    if (checkNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    //Preventing null reference when its not the 1st time through the loop
                    parent = checkNode;
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node fetchStudent(int key) {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {
                return currentNode;
            } else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else currentNode = currentNode.rightChild;
        }
    }

    public boolean showAllRecords(Node currentNode) {
        if (currentNode == null) {
            System.out.println("No Records to Display" + "\n");
            return true;
        }
        System.out.println("Name: " + currentNode.name + "\n" + "ID: " + currentNode.key + "\n" + "G.P.A: " + currentNode.gpa + "\n");
        //using recursion
        showAllRecords(currentNode.leftChild);
        showAllRecords(currentNode.rightChild);
        return false;
    }
//method to try to break some of the logic out of the already massive delete method
    public Node getParent(int key) {
        Node currentNode = root;
        parent = currentNode;
        while (true) {
            if (currentNode.key == key) {
                return parent;
            } else if (key < currentNode.key) {
                parent = currentNode;
                currentNode = currentNode.leftChild;
            } else {
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
    }

    public void deleteNode(int key) {
        //to handle case when you only have 1 node you are trying to update in list
        if (key == root.key)    {
            root = null;
        }
        else    {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {
                //handles the case when deletedNode has 2 children
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key < getParent(key).key)    {
                    getParent(currentNode.key).leftChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key > getParent(key).key)    {
                    getParent(currentNode.key).rightChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                //handles the case when deletedNode has no children
                if(currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key < getParent(key).key)   {
                    getParent(key).leftChild = null;
                    break;
                }
                if (currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key > getParent(key).key)    {
                   getParent(key).rightChild = null;
                   break;
                }
                //handles case when there is only 1 child on left side of tree
                if (currentNode.leftChild == null && currentNode.key < getParent(key).key) {
                    currentNode = currentNode.rightChild;
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.leftChild == null && currentNode.key > getParent(key).key) {
                    currentNode = currentNode.rightChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
                //handles case when there is only 1 child on right side of tree
                if (currentNode.rightChild == null && currentNode.key < getParent(key).key) {
                    currentNode = currentNode.leftChild;
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.rightChild == null && currentNode.key > getParent(key).key) {
                    currentNode = currentNode.leftChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
            }
            else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            }
            else {
                currentNode = currentNode.rightChild;
            }
        }
        }
        System.out.println("Record deleted successfully!" + "\n");
    }

    public void updateNode(int key, Node newStudent) {
        deleteNode(key);
        addNode(newStudent);
    }
}