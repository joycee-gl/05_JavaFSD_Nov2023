package dsa.binarysearchtree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {		
        
        test01();
    }
    
    static void test01() {
                
        BinarySearchTree bst = SampleBinarySearchTrees.sampleBST_01();
        
        Node _70 = bst.getRoot();	
        System.out.println("Root Node is " + _70);
        
        // Level - 2
        Node _50 = _70.getLeftNode();
        System.out.printf("Left of %s is %s", _70, _50);
        System.out.println();
        
        Node _90 = _70.getRightNode();
        System.out.printf("Right of %s is %s ", _70, _90);
        System.out.println();

        // Level - 3
        Node _30 = _50.getLeftNode();
        System.out.printf("Left of %s is %s", _50, _30);
        System.out.println();
        
        Node _60 = _50.getRightNode();
        System.out.printf("Right of %s is %s ", _50, _60);
        System.out.println();
        
        Node _80 = _90.getLeftNode();
        System.out.printf("Left of %s is %s", _90, _80);
        System.out.println();

        Node _100 = _90.getRightNode();
        System.out.printf("Right of %s is %s", _90, _100);
        System.out.println();
        
        // Level - 4			
        Node _20 = _30.getLeftNode();
        System.out.printf("Left of %s is %s", _30, _20);
        System.out.println();

        Node _40 = _30.getRightNode();
        System.out.printf("Right of %s is %s", _30, _40);
        System.out.println();		
    }
    
}
