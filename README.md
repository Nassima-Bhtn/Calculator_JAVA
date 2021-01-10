In this project we have a swing application (Calculator).

This calculator has the following features :
– operations : add, sub, mult, div and modulo.
– Provides button for those operations, along with buttons for numbers 0-9, a Enter button to
perform the result, and a clear button to clear the result being displayed (the text field set
to the value 0)
– The result is displayed at the top of the calculator in a JTextField. This value can
be reused for further operations.
– a menu to switch to the scientific mode. In this mode, this mode provides advanced computations: sin, cos, tan, and factorial, power.
– The calculator allows for complex expression using parenthesis.






Answers to the required questions.

 Exercise 1 : Netbeans

 Question 1.4
 
    1. What is a JFrame ?
     A JFrame is a top-level container that provides a window on the screen. It's the base on which other components are placed; for example : panels, labels, text fields, buttons...  
    
    2. What is the ContentPane and what is its type?
    JFrames have a content pane, these ContentPanes hold the components and have several layers (panes).
    ContentPane is of type Container. ( A content pane is automatically created when a JFrame object is created. the JFrame object uses the content pane to hold components in the frame. )
    
    3. How to add a JButton to the ContentPane?
    let's get the default contentPane :
        Container contentPane = getContentPane(); 
    then we create a button : 
        JButton button = new JButton("a_button");
    and finally we use the add() methode :
        contentPane.add(button);
    
    4. What is a layout manager?
    A Layout managers is used to control the way in which visual components are arranged in the GUI forms by determining the size and position of components within the containers.
    
    5. How to add a new BoxLayout to the ContentPane?
    using the same contentPane as before :
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
    
    6. How to implement a MouseListener and how to bind it to a JButton in the ContentPane?
        class Basic_Book extends JFrame implements ActionListener,MouseListener
        button.addActionListener(MouseListener);
    WHat is a KeyListener and how to use it? 
        A KeyListener is a listener interface for receiving keyboard events (keystrokes). A keyboard event is generated when a key is pressed, released, or typed. The relevant method in the listener object is then invoked, and the KeyEvent is passed to it.
    
    
    
    
    


