import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Read {
    public String read(){

        final String fileName = "src/����.txt";


            //��ȡ�ļ�
            BufferedReader br = null;
            StringBuffer sb = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf8")); //������Կ��Ʊ���
                sb = new StringBuffer();
                String line = null;
                while((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String data = new String(sb); //StringBuffer ==> String
            System.out.println("����Ϊ==> " + data);
            return data;
        }


}
