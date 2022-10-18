
/**
 * Operator nodes are the internal nodes of a binary expression tree.
 * 
 * @author Jordan Martin
 * @version 3/27/2022
 */
public class OperatorNode extends ExpressionNode {

  private Operator op;

  public OperatorNode(Operator op) {
    super();
    this.op = op;
  }

  public OperatorNode(Operator op, ExpressionNode left, ExpressionNode right) {
    super(left, right);
    this.op = op;
  }

  /**
   * Evaluate the expression rooted at this node and return the result.
   */
  @Override
  public double evaluate() {
    switch (op) {
      case ADD:
        return left().evaluate() + right().evaluate();
      case SUBTRACT:
        return left().evaluate() - right().evaluate();
      case MULTIPLY:
        return left().evaluate() * right().evaluate();
      default:
        return left().evaluate() / right().evaluate();
    }
    

  }

  @Override
  public String postfixString() {
    return left().postfixString() + " " + right().postfixString() + " " + op.opString();
  }

  @Override
  public String prefixString() {
    return op.opString() + " " + left().prefixString() + " " + right().prefixString();
  }

  @Override
  public String infixString() {
    return "(" + left().infixString() + " " + op.opString() + " " + right().infixString() + ")";
  }


}
