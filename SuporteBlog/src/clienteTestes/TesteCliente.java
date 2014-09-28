package clienteTestes;

import java.util.ArrayList;
import java.util.List;

import easyaccept.EasyAcceptFacade;
import fachada.Fachada;


public class TesteCliente { 

        public static void main(String[] args) throws Exception {

             

              List<String> files = new ArrayList<String>();

              files.add("us01.txt");
              files.add("us02.txt");
              files.add("us03.txt");
              files.add("us04.txt");
              files.add("us05.txt");
              files.add("us06.txt");
              files.add("us07.txt");
              files.add("us08.txt");
              files.add("us09.txt");
              files.add("us10.txt");
              files.add("us11.txt");
              files.add("us12.txt");
              files.add("us13.txt");
              files.add("us14.txt");
              

              Fachada yourTestFacade = new Fachada();

              EasyAcceptFacade eaFacade = new EasyAcceptFacade(yourTestFacade, files);

              eaFacade.executeTests();

              System.out.println(eaFacade.getCompleteResults());

        }

}