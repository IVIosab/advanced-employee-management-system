import java.util.ArrayList;

/**
 * This is the Company Unit
 * It is a part of 2 design patterns : the Composite pattern and the chain of responsibility
 * in the composite pattern it is considered as the component where the Team Class is the composite and Employee Class is the leaf
 * in Chain of responsibility pattern it is considered as the BaseHandler where it should have all boilerplate code that's common to all handlers classes, but since it is a part of the composite as well it has to be an interface so it only extends the Handler and we add the functionality of the component in it.
 */
interface CompanyUnit extends CompanyUnitHandler {
    public void showHelp();

    public String getName();

    public double getSalary();
}