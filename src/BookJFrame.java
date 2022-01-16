import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class BookJFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookJFrame
     */
    public BookJFrame() {
        initComponents();

    }
    
    public void clearFiedls(){
    BookInfoText.setText(null);
}
    

    public String readfile() throws FileNotFoundException
    {
        BufferedReader b = new BufferedReader(new FileReader("BookText.txt"));
        String line = null;
        String result = "";
        
        try {
            
            while((line = b.readLine()) != null)
            {
                String[] elements = line.split(",");
                
                result += line + "\n";
            }
            
            b.close();
        }
        catch(IOException ex){
            System.out.println("Error - file open");
        }
        
        return result;
    }
    
    public void deleteline() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        File tempFileDelete = new File("tempFileDelete.txt");
        String Id1 = IdText1.getText();
        boolean IDCheck;
        
        try {
            
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            BufferedWriter w = new BufferedWriter(new FileWriter(tempFileDelete));
            String line;
            IDCheck = false;
            
        
            while((line = r.readLine()) != null)
            {
                String[] BookElement = line.split(",");
                if(BookElement[0].equals(Id1)){
                    IDCheck = true;
                    continue;
                }
              
                w.write(line + System.getProperty("line.separator"));
            }
            
            if((IDCheck == true))
            {
            w.close(); 
            r.close(); 
            BookFile.delete();
            boolean isOkay = tempFileDelete.renameTo(BookFile);
            JOptionPane.showMessageDialog(null, "Line deleted succesfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Id is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void DisplayInfoWithTitle() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        String Title2 = TitleText2.getText();
        boolean TitleCheck;
        
        try {
            
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            String line;
            TitleCheck = false;
        
            while((line = r.readLine()) != null){
                String[] BookElement = line.split(",");
                if(BookElement[1].equals(Title2)){
                    TitleCheck = true;
                    BookInfoText.setText(line);
                    continue;
                }
               
            }
            
            if((TitleCheck == true))
            {
             
            r.close(); 
            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Title is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ListInfoWithAuthor() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        String Author2 = AuthorText2.getText();
        boolean AuthorCheck;
        
        try {
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            String line;
            AuthorCheck = false;
            
            while((line = r.readLine()) != null){
                String[] BookElement = line.split(",");
                if(BookElement[3].equals(Author2)){
                    AuthorCheck = true;
                    BookInfoText.setText(BookElement[1]+","+BookElement[8]);
                   
                    
                    continue;
                }
              
            }
            
            if((AuthorCheck == true))
            {
           
            r.close(); 
            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Author is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ListInfoWithCategory() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        String Category3 = CategoryText3.getText();
        boolean CategoryCheck;
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(BookFile));
            
            String line;
            CategoryCheck = false;
            
            BookInfoText.setText("");
            
        
            while((line = bufferedReader.readLine()) != null){
                String[] BookElement = line.split(",");
                if(BookElement[2].equals(Category3)){
                    CategoryCheck = true;
                    BookInfoText.append(BookElement[1] + " \n");
                    continue;
                }
                
            }
            
            if((CategoryCheck == true))
            {
            
            bufferedReader.close(); 
            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Category is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ImageShower() throws FileNotFoundException
    {
      
      String Id2 = IdText2.getText();
      boolean IdCheck2 = false;
      
      try
      {
            BufferedReader r = new BufferedReader(new FileReader("BookText.txt"));
            String line;
            IdCheck2 = false;
            
            while((line = r.readLine()) != null){
                String[] BookElement = line.split(",");
                if(BookElement[0].equals(Id2)){ 
                    IdCheck2 = true;
  
                  if(Id2.equals("1"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book1Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                  
                  if(Id2.equals("2"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book2Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                  
                  if(Id2.equals("3"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book3Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                  
                  if(Id2.equals("4"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book4Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                  
                  if(Id2.equals("5"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book5Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                  
                  if(Id2.equals("6"))
                  {
                    BufferedImage image;
                         try {
                         image = ImageIO.read(new File("C:\\Users\\alpago755\\Desktop\\FavoriteBooks\\Book6Cover.jpg"));
                         ImageLabel.setIcon(new ImageIcon(image));
                         } catch (IOException ex) {
                         System.out.println("The file cannot be opened.");
                         }      
                         continue;
                           
                  }
                   
                }

            }
            
            if((IdCheck2 == true))
            { 
            r.close(); 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Id is not exist");
            }

      }
      
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
        
    }
    
    
    public void ShowNumOfBooksWithYear() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        
        String yearText = YearText2.getText();
        boolean yearTextCheck;
        int count = 0;
        
        
        try {
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            
            String line;
            yearTextCheck = false;
            
        
            while((line = r.readLine()) != null)
            {
                String [] BookElement = line.split(",");
                
                if(BookElement[6].equals(yearText))
                {
                    yearTextCheck = true;
                    count++;
      
                    continue;
                }
                
                String s = Integer.toString(count);
                
                BookInfoText.setText(s);
              
               
            }
            
            if((yearTextCheck == true))
            {
            
            r.close(); 
            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Year is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ListInfoWithCategorySortingID() throws FileNotFoundException
    {
        File BookFile = new File("BookText.txt");
        
        String Category2 = CategoryText2.getText();
        boolean CategoryCheck2;
        
        BookInfoText.setText("");
        
        try {
            
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            
            String line;
            CategoryCheck2 = false;
            
        
            while((line = r.readLine()) != null)
            {
                String[] BookElement = line.split(",");
                if(BookElement[2].equals(Category2)){
                    CategoryCheck2 = true;
                    BookInfoText.append(BookElement[1]+ " , "+BookElement[5] + " \n");
                    
                    continue;
                }
              
                
            }
            
            if((CategoryCheck2 == true))
            {
            
            r.close(); 
            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Category is not exist");
            }
            
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int LastIdGetter()
    {
        File BookFile = new File("BookText.txt");
        String lastId;
        int idInt = 0;
        
        try {
            
            BufferedReader r = new BufferedReader(new FileReader(BookFile));
            String line;
            
        
            while((line = r.readLine()) != null)
            {
                String[] BookElement = line.split(",");
                lastId = BookElement[0];
                idInt = Integer.parseInt(lastId);  

            }
            
            idInt = idInt + 1;
 
            r.close(); 
   
            
        }   
        catch (FileNotFoundException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(FavoriteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idInt;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleText1 = new javax.swing.JTextField();
        AddBookButton = new javax.swing.JButton();
        CategoryText1 = new javax.swing.JTextField();
        AuthorText1 = new javax.swing.JTextField();
        AwardText = new javax.swing.JTextField();
        YearText = new javax.swing.JTextField();
        RateComboBox = new javax.swing.JComboBox<>();
        PageText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShortDescriptionText = new javax.swing.JTextArea();
        IdText1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DeleteBookButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TitleText2 = new javax.swing.JTextField();
        ShowInfoButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AuthorText2 = new javax.swing.JTextField();
        ListButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CategoryText3 = new javax.swing.JTextField();
        ListButton3 = new javax.swing.JButton();
        CategoryText2 = new javax.swing.JTextField();
        ListButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookInfoText = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        IdText2 = new javax.swing.JTextField();
        DisplayImageButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        ReadFileButton = new javax.swing.JButton();
        ClearTextButton = new javax.swing.JButton();
        ImageLabel = new javax.swing.JLabel();
        ShowNumBooksButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        YearText2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TitleText1.setText("Title");
        TitleText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleText1ActionPerformed(evt);
            }
        });

        AddBookButton.setText("Add a book");
        AddBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookButtonActionPerformed(evt);
            }
        });

        CategoryText1.setText("Category");

        AuthorText1.setText("Author F-L Name");

        AwardText.setText("Award Winner");

        YearText.setText("Year");
        YearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearTextActionPerformed(evt);
            }
        });

        RateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        RateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateComboBoxActionPerformed(evt);
            }
        });

        PageText.setText("Number of Page");

        ShortDescriptionText.setColumns(20);
        ShortDescriptionText.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        ShortDescriptionText.setRows(5);
        ShortDescriptionText.setText("Short Description\n");
        jScrollPane1.setViewportView(ShortDescriptionText);

        IdText1.setText("ID");
        IdText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdText1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setText("Adding Book to The Text");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("Deleting Book With ID");

        DeleteBookButton.setText("Delete a Book");
        DeleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setText("Showing Informations With Title");

        TitleText2.setText("Title");
        TitleText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleText2ActionPerformed(evt);
            }
        });

        ShowInfoButton.setText("Show Info");
        ShowInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowInfoButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("Listing Title&Description With Author Name");

        AuthorText2.setText("Author F-L Name");
        AuthorText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorText2ActionPerformed(evt);
            }
        });

        ListButton2.setText("List");
        ListButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel5.setText("Listing Title With Category");

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel6.setText("Listing Title&Rate With Category");

        CategoryText3.setText("Category");
        CategoryText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryText3ActionPerformed(evt);
            }
        });

        ListButton3.setText("List ");
        ListButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButton3ActionPerformed(evt);
            }
        });

        CategoryText2.setText("Category");

        ListButton1.setText("List");
        ListButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButton1ActionPerformed(evt);
            }
        });

        BookInfoText.setColumns(20);
        BookInfoText.setRows(5);
        BookInfoText.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                BookInfoTextAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(BookInfoText);

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel7.setText("Book Image");

        IdText2.setText("ID");
        IdText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdText2ActionPerformed(evt);
            }
        });

        DisplayImageButton.setText("Display Image");
        DisplayImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayImageButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        ReadFileButton.setText("Read File");
        ReadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadFileButtonActionPerformed(evt);
            }
        });

        ClearTextButton.setText("Clear Text Area");
        ClearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTextButtonActionPerformed(evt);
            }
        });

        ShowNumBooksButton.setText("Show");
        ShowNumBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowNumBooksButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel8.setText("Displaying Number of Books With Year");

        YearText2.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DisplayImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdText2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReadFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(ClearTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(TitleText2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ShowInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TitleText1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(CategoryText1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(AuthorText1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(AwardText, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addComponent(RateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(YearText, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(PageText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(AddBookButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(CategoryText2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ListButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel6))
                                            .addGap(49, 49, 49)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(AuthorText2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(40, 40, 40)
                                                    .addComponent(ListButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel5)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(CategoryText3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(39, 39, 39)
                                                    .addComponent(ListButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(YearText2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(IdText1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ShowNumBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(DeleteBookButton)))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(AddBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TitleText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CategoryText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AuthorText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AwardText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TitleText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CategoryText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ListButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ShowNumBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YearText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReadFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(ClearTextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(IdText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(DisplayImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleText1ActionPerformed

    private void YearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearTextActionPerformed

    private void AddBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookButtonActionPerformed
        String  Title = TitleText1.getText();
        String Category1 = CategoryText1.getText();
        String Author1 = AuthorText1.getText();
        String Award = AwardText.getText();
        Integer Rate = Integer.parseInt((String) RateComboBox.getSelectedItem());
        String Year = YearText.getText();
        String Page = PageText.getText();
        String Sdescription = ShortDescriptionText.getText();
        int Id = LastIdGetter();
        

        try
        {
            FileWriter Writer = new FileWriter("BookText.txt",true);
            Writer.write(Id+","+Title+","+Category1+","+Author1+","+Award+","+Rate+","+Year+","+Page+","+Sdescription);
            Writer.close();
            JOptionPane.showMessageDialog(null,"Add Success");
            setVisible(false);
            new BookJFrame().setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }//GEN-LAST:event_AddBookButtonActionPerformed

    private void RateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateComboBoxActionPerformed
       
        
    }//GEN-LAST:event_RateComboBoxActionPerformed

    private void DeleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookButtonActionPerformed
        
        try
        {
           deleteline();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Error line cannot be deleted");
        }
    }//GEN-LAST:event_DeleteBookButtonActionPerformed

    private void ReadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadFileButtonActionPerformed
       try
       {
           String s = readfile();
           BookInfoText.setText(s);
       
       } 
       catch (FileNotFoundException ex) {
            System.out.println("Error file cannot be opened");
        }
    }//GEN-LAST:event_ReadFileButtonActionPerformed

    private void BookInfoTextAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_BookInfoTextAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BookInfoTextAncestorAdded

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ClearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTextButtonActionPerformed
        clearFiedls();
    }//GEN-LAST:event_ClearTextButtonActionPerformed

    private void IdText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdText1ActionPerformed
        Integer Id1 = Integer.parseInt((String) IdText1.getText());
    }//GEN-LAST:event_IdText1ActionPerformed

    private void ShowInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowInfoButtonActionPerformed
         try
        {
           DisplayInfoWithTitle();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Information cannot be listed");
        }
    }//GEN-LAST:event_ShowInfoButtonActionPerformed

    private void TitleText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleText2ActionPerformed
     
    }//GEN-LAST:event_TitleText2ActionPerformed

    private void AuthorText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorText2ActionPerformed

    private void ListButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButton2ActionPerformed
         try
        {
           ListInfoWithAuthor();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Information cannot be listed");
        }
    }//GEN-LAST:event_ListButton2ActionPerformed

    private void CategoryText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryText3ActionPerformed

    private void ListButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButton3ActionPerformed
        try
        {
           ListInfoWithCategory();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Information cannot be listed");
        }
    }//GEN-LAST:event_ListButton3ActionPerformed

    private void DisplayImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayImageButtonActionPerformed
        try
        {
           ImageShower();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Error Image cannot be opened");
        }
    }//GEN-LAST:event_DisplayImageButtonActionPerformed

    private void IdText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdText2ActionPerformed

    private void ShowNumBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowNumBooksButtonActionPerformed
       try
        {        
            
        ShowNumOfBooksWithYear();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Error Image cannot be opened");
        }

    }//GEN-LAST:event_ShowNumBooksButtonActionPerformed

    private void ListButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButton1ActionPerformed
        try
        {        
            
        ListInfoWithCategorySortingID();
           
        }
         catch (FileNotFoundException ex) {
            System.out.println("Error Image cannot be opened");
        }
    }//GEN-LAST:event_ListButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBookButton;
    private javax.swing.JTextField AuthorText1;
    private javax.swing.JTextField AuthorText2;
    private javax.swing.JTextField AwardText;
    private javax.swing.JTextArea BookInfoText;
    private javax.swing.JTextField CategoryText1;
    private javax.swing.JTextField CategoryText2;
    private javax.swing.JTextField CategoryText3;
    private javax.swing.JButton ClearTextButton;
    private javax.swing.JButton DeleteBookButton;
    private javax.swing.JButton DisplayImageButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField IdText1;
    private javax.swing.JTextField IdText2;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JButton ListButton1;
    private javax.swing.JButton ListButton2;
    private javax.swing.JButton ListButton3;
    private javax.swing.JTextField PageText;
    private javax.swing.JComboBox<String> RateComboBox;
    private javax.swing.JButton ReadFileButton;
    private javax.swing.JTextArea ShortDescriptionText;
    private javax.swing.JButton ShowInfoButton;
    private javax.swing.JButton ShowNumBooksButton;
    private javax.swing.JTextField TitleText1;
    private javax.swing.JTextField TitleText2;
    private javax.swing.JTextField YearText;
    private javax.swing.JTextField YearText2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private static class FavoriteBooks {

        public FavoriteBooks() {
        }
    }
}
