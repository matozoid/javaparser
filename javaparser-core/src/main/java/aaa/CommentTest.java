package aaa;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.TreeVisitor;

import static com.github.javaparser.JavaParser.parse;

public class CommentTest {
    public static void main(String[] args) {
        CompilationUnit cu = parse("/*abc*/class/*def*/ X/*ghi*/{/*jkl*/int/*mno*/ /*pqr*/x/*s*/(/*t*/)/*u*/{/*vwx*/}/*y*/}/*z*/");
        System.out.println(new YamlPrinter(true).output(cu));
        new TreeVisitor(){
            @Override
            public void process(Node n) {
                System.out.println(n.getMetaModel().getTypeName() + "\t\t" + n.getLeadingComments().toString().replace("\n", "") + "\t\t" + n.getTrailingComments().toString().replace("\n", ""));    
            }
        }.visitPreOrder(cu);
    }
}

/*abc*/
class/*def*/ X/*ghi*/ {

    /*jkl*/
    void/*mno*/ /*pqr*/ x /*s*/( /*t*/) /*u*/ { 
        /*vwx*/
    }
    /*y*/
}
/*z*/
