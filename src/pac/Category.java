package pac;

import java.io.*;
import java.util.Arrays;

public class Category {
    public String[] level1;
    public String[] level2;
    public String[] level3;
    public final int Numlevels;

    public final int N=3;

    public Category(String[] level1,String[] level2,String[] level3,int Numlevels){
        this.level1=level1;
        this.level2=level2;
        this.level3=level3;
        this.Numlevels=Numlevels;

    }

    public Category ReadCategory(String filepath) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(new File(filepath));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int data = bufferedInputStream.read();
        String dataString=new String();
        while (data != -1) {
            // System.out.print((char) data);
            dataString=dataString+(char)data;
            data = bufferedInputStream.read();
        }

        bufferedInputStream.close();

        // System.out.print(dataString);

        String[] All=dataString.split(" ");
        int len=All.length;
        
        String[] levle1=Arrays.copyOfRange(All, 0, len/N);
        String[] levle2=new String[len/N];
        String[] levle3=new String[len/N];

        for(int i=0;i<len;i++){
            int n=i/N;
            if(i%N==0){
                levle1[n]=All[i];
            }
            else if(i%N==1){
                levle2[n]=All[i];
            }
            else{
                levle3[n]=All[i];
            }
        }
        Category categories=new Category(levle1, levle2, levle3,len/N);

        return categories;
    }

    public void WriteCategory(String filepath) throws IOException
    {
        FileOutputStream fos=new FileOutputStream(filepath);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        String content="我是缓冲输出流测试数据！";
        bos.write(content.getBytes(),0,content.getBytes().length);
        bos.flush();
        bos.close();

    }
}
