package sd;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jsaias
 */
public class TesteAcessoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // coloque os argumentos
        PostgresConnector pc = new PostgresConnector(args[0], args[1], args[2], args[3]);
        // NOTA: não DEVE ter configuracoes no código fonte!!!
        // passar como argumento ou ler de .properties

        // estabelecer a ligacao ao SGBD
        pc.connect();
        Statement stmt = pc.getStatement();

        // *******************
        // update/insert
        try {
            stmt.executeUpdate("insert into personl99999 values(1,'O.Gb','09/07/2002')");
            // o objeto java.util.Date será convertido para String com toString().
            // AQUI: operação para inserir um registo com o seu nome...

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems on insert...");
        }

        // ******************
        // query	
        try {

            ResultSet rs = stmt.executeQuery("SELECT id,name,birth,extract(hour from birth) as hh from personl99999 order by birth");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                java.sql.Timestamp birth = rs.getTimestamp("birth");
                java.sql.Time time = rs.getTime("birth");

                System.out.println("Id: " + id + "  name: " + name
                        + "  birth: " + birth + "   time: " + time);
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }

        // desligar do SGBD:
        pc.disconnect();
    }

}
