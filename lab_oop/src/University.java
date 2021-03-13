public class University {
    private Lab[] labs;
    private int capacity;
    private int currentIndex;

    /**
     * make a university that has a capacity and a number of labs
     * 
     * @param capacity
     */
    public University(int capacity) {
        this.capacity = capacity;
        this.currentIndex = 0;
        this.labs = new Lab[capacity];
    }

    /**
     * get university capacity
     * 
     * @return int
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * set university capacity which must be equal or greater than zero
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

    /**
     * add a lab to the university
     * 
     * @param lab
     */
    public void addLab(Lab lab) {
        if (currentIndex <= capacity) {
            this.labs[this.currentIndex] = lab;
            (this.currentIndex)++;
        } else {
            System.out.println("university capacity is full");
        }
    }

    /**
     * add an array of labs to the university
     * 
     * @param labs
     */
    public void setLabs(Lab[] labs) {
        for (int i = 0; i < labs.length; i++) {
            this.addLab(labs[i]);
        }
    }

    /**
     * print all labs added in the university
     */
    public void printLabs() {
        System.out.println("***************************************");
        for (int i = 0; i < this.labs.length; i++) {
            Lab lab = labs[i];

            System.out.println(i + 1 + ")");
            System.out.println("Day: " + lab.getDay());
            System.out.println("capacity: " + lab.getCapacity());
            System.out.println("average : " + lab.getAvg());
            System.out.println("***************************************");
        }
    }
}
