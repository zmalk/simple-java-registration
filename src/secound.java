
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Logger;

class secound extends JFrame implements ActionListener {
    secound () {
        JPanel student1,instructor1,course1;
        JTabbedPane pane;
        JButton student, instructor, course;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      //  setResizable(false);
        setTitle("JPANEL CREATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(100, 100, 645, 530);
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();
        //Creating a JPanel for the JFrame
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setLayout(null);
        panel2.setLayout(null);
        //
        JLabel label = new JLabel("Click on the desired button");
        label.setBounds(30, 10, 200, 20);
        panel.add(label);
        //
        panel.setBackground(Color.yellow);
        panel.setBounds(10, 10, 200, 470);
        //Panel 2
        panel2.setBackground(Color.red);
        panel2.setBounds(210, 10, 410, 470);
        // Panel border
        panel.setBorder(br);
        panel2.setBorder(br);
        //adding the panel to the Container of the JFrame
        c.add(panel);
        c.add(panel2);
        //
        student1=new JPanel();
        student1.setLayout(null);
        JLabel sinfo = new JLabel("Student information");
        sinfo.setFont(new Font("Arial", Font.BOLD, 20));
        sinfo.setSize(300, 20);
        sinfo.setLocation(110, 30);
        student1.add(sinfo);
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        name.setSize(100, 20);
        name.setLocation(10, 80);
        student1.add(name);
        JLabel mobile = new JLabel("Mobile");
        mobile.setFont(new Font("Arial", Font.PLAIN, 18));
        mobile.setSize(100, 20);
        mobile.setLocation(10, 160);
        student1.add(mobile);
        JLabel CourseID = new JLabel("CourseID");
        CourseID.setFont(new Font("Arial", Font.PLAIN, 18));
        CourseID.setSize(100, 20);
        CourseID.setLocation(10, 240);
        student1.add(CourseID);

        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 16));
        tname.setSize(190, 30);
        tname.setLocation(170, 80);
        student1.add(tname);

        JTextField tmobile = new JTextField();
        tmobile.setFont(new Font("Arial", Font.PLAIN, 16));
        tmobile.setSize(190, 30);
        tmobile.setLocation(170, 160);
        student1.add(tmobile);
        JTextField tcourse = new JTextField();
        tcourse.setFont(new Font("Arial", Font.PLAIN, 16));
        tcourse.setSize(190, 30);
        tcourse.setLocation(170, 240);
        student1.add(tcourse);

        JButton add = new JButton("Add");
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setSize(100, 30);
        add.setLocation(50, 350);
        add.addActionListener(this);
        student1.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement insert;
                String name=tname.getText();
                String mobile=tmobile.getText();
                String course=tcourse.getText();

                    try{
                        if ( name.equals("")|| mobile.equals("") || course.equals("")) {
                            JOptionPane.showMessageDialog(add, "enter all the inputs");}
                        Class.forName("oracle.jdbc.OracleDriver");
                        Connection con = DriverManager.getConnection
                                ("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                        insert=con.prepareStatement("insert into student(stid,SNAME,smobile,coid)values(inc.nextval,?,?,?)");
                        insert.setString(1,name);
                        insert.setString(2,mobile);
                        insert.setString(3,course);
                        insert.executeUpdate();
                        JOptionPane.showMessageDialog(add, "OK ");
                        tname.setText("");
                        tmobile.setText("");
                        tcourse.setText("");
                        tname.requestFocus();

                    }
                    catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    catch(Exception ex)
                    { JOptionPane.showMessageDialog(null ,e); }


}});
        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.BOLD, 15));
        delete.setSize(100, 30);
        delete.setLocation(200, 350);
        delete.addActionListener(this);
        student1.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement deletee;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    deletee=con.prepareStatement("delete from student where stid="+response+"");
                    int i=deletee.executeUpdate();
                    if(i>0){JOptionPane.showMessageDialog(delete, "delete done ");}
                    else JOptionPane.showMessageDialog(null, "this is not exit id ");
                  //  deletee.executeUpdate();

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }



            }
        });
        JButton edit = new JButton("Edit");
        edit.setFont(new Font("Arial", Font.BOLD, 15));
        edit.setSize(100, 30);
        edit.setLocation(50, 400);
        edit.addActionListener(this);
        student1.add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement edit;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    edit=con.prepareStatement("update student set sname=?,smobile=?,coid=? where stid="+response+"");
                        JTextField nField = new JTextField(5);
                        JTextField cField = new JTextField(5);
                        JTextField mField = new JTextField(8);
                        JPanel myPanel = new JPanel();
                        myPanel.add(new JLabel("name:"));
                        myPanel.add(nField);
                        myPanel.add(new JLabel("mobile:"));
                        myPanel.add(mField);
                        myPanel.add(new JLabel("coid:"));
                        myPanel.add(cField);
                        //
                        int result = JOptionPane.showConfirmDialog(null, myPanel,
                                "Please Enter name and mobile,coid Values", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            edit.setString(1, nField.getText());
                            edit.setString(2, mField.getText());
                            edit.setString(3, cField.getText());
                            edit.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Update done");
                        }

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });
        JButton search = new JButton("Search");
        search.setFont(new Font("Arial", Font.BOLD, 15));
        search.setSize(100, 30);
        search.setLocation(200, 400);
        search.addActionListener(this);
        student1.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement search;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    search=con.prepareStatement("select sname,coid,smobile from student where stid="+response+"");
                    ResultSet rs1 = search.executeQuery();
                    if(rs1.next()==false)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Record Not Found");
                        tname.setText("");
                        tcourse.setText("");
                        tmobile.setText("");
                        tname.requestFocus();
                    }
                    else
                    {

                        tname.setText(rs1.getString("sname"));
                        tmobile.setText(rs1.getString("smobile"));
                        tcourse.setText(rs1.getString("coid"));
                    }
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });
        //
        instructor1=new JPanel();
        instructor1.setLayout(null);
        JLabel Iinfo = new JLabel("Instructor information");
        Iinfo.setFont(new Font("Arial", Font.BOLD, 20));
        Iinfo.setSize(300, 20);
        Iinfo.setLocation(110, 30);
        instructor1.add(Iinfo);

        JLabel iname = new JLabel("Instructor Name");
        iname.setFont(new Font("Arial", Font.PLAIN, 18));
        iname.setSize(200, 20);
        iname.setLocation(10, 80);
        instructor1.add(iname);

        JLabel salary = new JLabel("Salary");
        salary.setFont(new Font("Arial", Font.PLAIN, 18));
        salary.setSize(200, 20);
        salary.setLocation(10, 140);
        instructor1.add(salary);

        JLabel tax = new JLabel("Tax");
        tax.setFont(new Font("Arial", Font.PLAIN, 18));
        tax.setSize(200, 20);
        tax.setLocation(10, 200);
        instructor1.add(tax);

        JLabel icourse = new JLabel("CourseID");
        icourse.setFont(new Font("Arial", Font.PLAIN, 18));
        icourse.setSize(200, 20);
        icourse.setLocation(10, 260);
        instructor1.add(icourse);

        JTextField tiname = new JTextField();
        tiname.setFont(new Font("Arial", Font.PLAIN, 16));
        tiname.setSize(190, 30);
        tiname.setLocation(170, 80);
        instructor1.add(tiname);

        JTextField tsalary = new JTextField();
        tsalary.setFont(new Font("Arial", Font.PLAIN, 16));
        tsalary.setSize(190, 30);
        tsalary.setLocation(170, 140);
        instructor1.add(tsalary);

        JTextField ttax = new JTextField();
        ttax.setFont(new Font("Arial", Font.PLAIN, 16));
        ttax.setSize(190, 30);
        ttax.setLocation(170, 200);
        instructor1.add(ttax);

        JTextField tcoursei = new JTextField();
        tcoursei.setFont(new Font("Arial", Font.PLAIN, 16));
        tcoursei.setSize(190, 30);
        tcoursei.setLocation(170, 260);
        instructor1.add(tcoursei);

        //
        JButton iadd = new JButton("Add");
        iadd.setFont(new Font("Arial", Font.BOLD, 15));
        iadd.setSize(100, 30);
        iadd.setLocation(50, 350);
        iadd.addActionListener(this);
        instructor1.add(iadd);
        iadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement insert;
                String name=tiname.getText();
                String tax=ttax.getText();
                String course=tcoursei.getText();
                String salary=tsalary.getText();
              //  String x="1";
                try{
                    if ( name.equals("")|| tax.equals("") || course.equals("") ) {
                        JOptionPane.showMessageDialog(add, "enter all the inputs");}
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection
                            ("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    insert=con.prepareStatement("insert into instructor(inid,iNNAME,salary,tax,coid)values(incc.nextval,?,?,?,?)");
                    insert.setString(1,name);
                    insert.setString(2,salary);
            //          insert.setString(2,"600");
            //                   else
            //                    insert.setString(2,salary);
                    insert.setString(3,tax);
                    insert.setString(4,course);
                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(iadd, "OK ");
                    tiname.setText("");
                    ttax.setText("");
                    tcoursei.setText("");
                    tsalary.setText("");
                    tiname.requestFocus();

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }


            }});

        JButton idelete = new JButton("Delete");
        idelete.setFont(new Font("Arial", Font.BOLD, 15));
        idelete.setSize(100, 30);
        idelete.setLocation(200, 350);
        idelete.addActionListener(this);
        instructor1.add(idelete);
        idelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement deletee;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    deletee=con.prepareStatement("delete from instructor where inid="+response+"");
                    int i=deletee.executeUpdate();
                    if(i>0){JOptionPane.showMessageDialog(idelete, "delete done ");}
                    else JOptionPane.showMessageDialog(null, "this is not exit id ");
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }



            }
        });


        JButton iedit = new JButton("Edit");
        iedit.setFont(new Font("Arial", Font.BOLD, 15));
        iedit.setSize(100, 30);
        iedit.setLocation(50, 400);
        iedit.addActionListener(this);
        instructor1.add(iedit);
        iedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement edit;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    edit=con.prepareStatement("update instructor set inname=?,salary=?,tax=?,coid=? where inid="+response+"");
                    JTextField nField = new JTextField(5);
                    JTextField sField = new JTextField(5);
                    JTextField tField = new JTextField(8);
                    JTextField cField = new JTextField(5);
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("name:"));
                    myPanel.add(nField);
                    myPanel.add(new JLabel("salary:"));
                    myPanel.add(sField);
                    myPanel.add(new JLabel("tax:"));
                    myPanel.add(tField);
                    myPanel.add(new JLabel("coid:"));
                    myPanel.add(cField);
                    //
                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter name ,salary,tax,coid Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        edit.setString(1, nField.getText());
                        edit.setString(2, sField.getText());
                        edit.setString(3, tField.getText());
                        edit.setString(4, cField.getText());
                        edit.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update done");
                    }

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });

        JButton isearch = new JButton("Search");
        isearch.setFont(new Font("Arial", Font.BOLD, 15));
        isearch.setSize(100, 30);
        isearch.setLocation(200, 400);
        isearch.addActionListener(this);
        instructor1.add(isearch);
        isearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement search;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    search=con.prepareStatement("select inname,salary,tax,coid from instructor where inid="+response+"");
                    ResultSet rs1 = search.executeQuery();
                    if(rs1.next()==false)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Record Not Found");
                        tiname.setText("");
                        tcoursei.setText("");
                        tsalary.setText("");
                        ttax.setText("");
                        tiname.requestFocus();
                    }
                    else
                    {

                        tiname.setText(rs1.getString("inname"));
                        tcoursei.setText(rs1.getString("coid"));
                        tsalary.setText(rs1.getString("salary"));
                        ttax.setText(rs1.getString("tax"));
                    }
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });
        //
        course1=new JPanel();
        course1.setLayout(null);
        JLabel cinfo = new JLabel("Course information");
        cinfo.setFont(new Font("Arial", Font.BOLD, 20));
        cinfo.setSize(300, 20);
        cinfo.setLocation(110, 30);
        course1.add(cinfo);

        JLabel courseid = new JLabel("Course ID");
        courseid.setFont(new Font("Arial", Font.PLAIN, 18));
        courseid.setSize(200, 20);
        courseid.setLocation(10, 80);
        course1.add(courseid);

        JLabel courset = new JLabel("Course Title");
        courset.setFont(new Font("Arial", Font.PLAIN, 18));
        courset.setSize(200, 20);
        courset.setLocation(10, 160);
        course1.add(courset);

        JLabel Dep = new JLabel("Department Name");
        Dep.setFont(new Font("Arial", Font.PLAIN, 18));
        Dep.setSize(200, 20);
        Dep.setLocation(10, 240);
        course1.add(Dep);

        JTextField tcid = new JTextField();
        tcid.setFont(new Font("Arial", Font.PLAIN, 16));
        tcid.setSize(190, 30);
        tcid.setLocation(170, 80);
        course1.add(tcid);

        JTextField tcname = new JTextField();
        tcname.setFont(new Font("Arial", Font.PLAIN, 16));
        tcname.setSize(190, 30);
        tcname.setLocation(170, 160);
        course1.add(tcname);

        JTextField dept = new JTextField();
        dept.setFont(new Font("Arial", Font.PLAIN, 16));
        dept.setSize(190, 30);
        dept.setLocation(170, 240);
        course1.add(dept);
        //
        JButton cadd = new JButton("Add");
        cadd.setFont(new Font("Arial", Font.BOLD, 15));
        cadd.setSize(100, 30);
        cadd.setLocation(50, 350);
        cadd.addActionListener(this);
        course1.add(cadd);
        cadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement insert;
                String cid=tcid.getText();
                String name=tcname.getText();
                String deptt=dept.getText();

                try{
                    if ( cid.equals("")|| name.equals("") || dept.equals("")) {
                        JOptionPane.showMessageDialog(cadd, "enter all the inputs");}
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection
                            ("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    insert=con.prepareStatement("insert into course(coid,CTITLE,DEPT_NAME)values(?,?,?)");
                    insert.setString(1,cid);
                    insert.setString(2,name);
                    insert.setString(3,deptt);
                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(cadd, "OK ");
                    tcid.setText("");
                    tcname.setText("");
                    dept.setText("");
                    tcid.requestFocus();

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }


            }});
        JButton cdelete = new JButton("Delete");
        cdelete.setFont(new Font("Arial", Font.BOLD, 15));
        cdelete.setSize(100, 30);
        cdelete.setLocation(200, 350);
        cdelete.addActionListener(this);
        course1.add(cdelete);
        cdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement deletee;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    deletee=con.prepareStatement("delete from course where coid="+response+"");
                    int i=deletee.executeUpdate();
                    if(i>0){  JOptionPane.showMessageDialog(cdelete, "delete done ");}
                    else JOptionPane.showMessageDialog(null, "this is not exit id ");
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }



            }
        });

        JButton cedit = new JButton("Edit");
        cedit.setFont(new Font("Arial", Font.BOLD, 15));
        cedit.setSize(100, 30);
        cedit.setLocation(50, 400);
        cedit.addActionListener(this);
        cedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement edit;

                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    edit=con.prepareStatement("update course set ctitle=?, DEPT_NAME=?where coid="+response+"");
                    JTextField nField = new JTextField(5);
                    JTextField sField = new JTextField(5);
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("CTITLE:"));
                    myPanel.add(nField);
                    myPanel.add(new JLabel("DEPT_NAME:"));
                    myPanel.add(sField);

                    //
                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter CTITLE and DEPT_NAME", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        edit.setString(1, nField.getText());
                        edit.setString(2, sField.getText());
                        edit.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update done");
                    }

                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });
        course1.add(cedit);
        JButton csearch = new JButton("Search");
        csearch.setFont(new Font("Arial", Font.BOLD, 15));
        csearch.setSize(100, 30);
        csearch.setLocation(200, 400);
        csearch.addActionListener(this);
        course1.add(csearch);
        csearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement search;
                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");
                    String response=JOptionPane.showInputDialog("enter the id");
                    search=con.prepareStatement("select COID,CTITLE,DEPT_NAME from course where coid="+response+"");
                    ResultSet rs1 = search.executeQuery();
                    if(rs1.next()==false)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Record Not Found");
                        tcid.setText("");
                        tcname.setText("");
                        dept.setText("");
                        tiname.requestFocus();
                    }
                    else
                    {

                        tcid.setText(rs1.getString("coid"));
                        tcname.setText(rs1.getString("CTITLE"));
                        dept.setText(rs1.getString("DEPT_NAME"));

                    }
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex)
                { JOptionPane.showMessageDialog(null ,e); }

            }
        });
        //

        panel2.add(pane = new JTabbedPane());
        pane.setBounds(0, -30, 410, 500);
        pane.addTab("Line", student1);
        pane.addTab("Circle", instructor1);
        pane.addTab("Rectangle", course1);
        //

        student = new JButton("student");
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSize(100, 30);
        student.setLocation(50, 100);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(0);
            }
        });
        panel.add(student);


        instructor = new JButton("instructor");
        instructor.setFont(new Font("Arial", Font.PLAIN, 15));
        instructor.setSize(100, 30);
        instructor.setLocation(50, 200);
        instructor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(1);
            }
        });
        panel.add(instructor);

        course = new JButton("course");
        course.setFont(new Font("Arial", Font.PLAIN, 15));
        course.setSize(100, 30);
        course.setLocation(50, 300);
        course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(2);
            }
        });
        panel.add(course);
        setVisible(true);


    }
    public static void main(String[] args) {
        new secound ();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}