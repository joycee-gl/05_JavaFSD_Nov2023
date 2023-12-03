## Order of invocation

- When a new object is created, the order of invocation is as follows:
    - Static objects, if any in this class, will be created first
    - Static code blocks
    - Super class (if any) constructor
    - It's own constructor

    - when paramterized constructors are used
        - then we need to include the super(param..., param..., ..) to call the superclass constructor frm within the sub class constructor
    




