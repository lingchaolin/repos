package com.aowin.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Swing ����AWT�����ģ���ȫ��java���Ա�д�ģ��������ڱ�������ƽ̨
 * @author Administrator
 *
 */
public class SwingOne {

	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
		
//		swing ��Ĭ�ϴ��������ģ���ӵ�ʱ��Ҫ��ȡ����
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
		JButton button=new JButton("a button");
//		��ȡ��ť�ϵ����֣�getText;
		button.getText();
//		���ð�ť�ϵ����֣�setText;
		button.setText("ȷ��");
//		ʹ��ť�����ã�
//		button.setEnabled(false);
		con.add(button);
		
		JLabel label=new JLabel("a label") ;
		label.setForeground(Color.RED);//����������ɫ
		con.add(label);
//���ͼƬ
		JPanel panel=new JPanel() {
			public  void paintComponent(Graphics g) {
				Image back=GameUtil.getImage("images/Law.jpg");
				g.drawImage(back,-150,0,950,630,null);
			}
		};
//		panel.add(button);
//		con.add(panel);
//		JTextField-�ı���--��������--�޸����֣�
		JTextField jt=new JTextField("text",8);//--���ÿ��
	
		
//		setText()-�������֡��޸�����
//		seEditable(false)-����Ϊ���ɱ༭
		jt.setEditable(false);
		con.add(jt);
//		�ı���
		JTextArea jta=new JTextArea("����",4,8);//���ÿ�ȳ���
//		�Զ�����
		jta.setLineWrap(true);
//		��ӻ�����壻
		JScrollPane jsp=new JScrollPane(jta);

		con.add(jsp);
//		�����JPasswordField
		JLabel label2=new JLabel("���룺");
		con.add(label2);
		JPasswordField jpd=new JPasswordField("123",6);
		con.add(jpd);
//		���û����ַ���--�����������������ʾ����'********'����'^^^^^^^^^'���ǡ���
		jpd.setEchoChar('^');
//		��ȡ����--char����
		char[]arr=jpd.getPassword();
		String str=new String(arr);
//		System.out.println("������:"+str);
		
//		����屣��һ�£�
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel lab3=new JLabel("�Ա�");
		JRadioButton rb1=new JRadioButton("��");
		JRadioButton rb2=new JRadioButton("Ů");
		panel2.add(lab3);
		panel2.add(rb1);
		panel2.add(rb2);
//		-�߼�����
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		rb1.setSelected(true);//����ѡ��
		
		con.add(panel2);
//		��ѡ��
		JPanel panel3=new JPanel();
		panel3.add(new JLabel("ͶƱѡ�������ʲô��"));
		JCheckBox cb1=new JCheckBox("����");
		JCheckBox cb2=new JCheckBox("����");
		JCheckBox cb3=new JCheckBox("��ѧ");
		JCheckBox cb4=new JCheckBox("Ӣ��");
		panel3.add(cb1);
		panel3.add(cb2);
		panel3.add(cb3);
		panel3.add(cb4);
//		���ñ�ѡ�У�
		cb4.setSelected(true);
		cb1.setEnabled(false);
		con.add(panel3);
//		����ʽ�б��
		JPanel pan1=new JPanel();
		pan1.add(new JLabel("�������:"));
		String []arr2= {"2015","2016","2017"};
		JComboBox jcb=new JComboBox(arr2);
//		���á���ȡ��ѡ�е��
		jcb.setSelectedIndex(2);
		jcb.setSelectedItem("2017");
		String item=(String) jcb.getSelectedItem();//Ĭ�Ϸ���Object����
//		System.out.println("ѡ�е��ǣ�"+item);
		pan1.add(jcb);
		con.add(pan1);
		
//		�˵�
//		JMenuBar-�˵���
		JMenuBar jmbar=new JMenuBar();
		
		jf.setJMenuBar(jmbar);//����-���ò˵���
//		JMenu-����һ��˵���
		JMenu jmf=new JMenu("FileF");
		jmbar.add(jmf);
		
		JMenu jms=new JMenu("FileS");
		jmf.add(jms);
		
//		JMenuItem-û����һ���˵��Ĳ˵���
		JMenuItem item1=new JMenuItem("ITEM1");
		jms.add(item1);
		jms.addSeparator();
		JMenuItem item2=new JMenuItem("ITEM2");
		jms.add(item2);
//		���-JTable
		String []colNames= {"���","����","����ֵ"};
//		����������������
		DefaultTableModel model=new DefaultTableModel(colNames,8);
		JTable table=new JTable(model);//���ݱ��ģ�����������
		JScrollPane jsp2=new JScrollPane(table);//�����������װ�α��
//		�趨����С
		jsp2.setPreferredSize(new Dimension(300,150));//--
		con.add(jsp2);
//		�������--��ģ�������
//		addRow
		Object []data1= {"1","��������",1233234235};
		Object []data2= {"2","������",123323423};
		Object []data3= {"3","����",12332};
//		ɾ��
		model.removeRow(1);//ɾ����--ָ���к�
		
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
//		�޸�
		model.setValueAt(35, 2, 2);//�У��ж��Ǵ�0��ʼ����ģ�
//		��ѯ
		Object value1=model.getValueAt(2, 2);//��ѯָ����Ԫ���ֵ
		int rows=model.getRowCount();
		int columns=model.getColumnCount();//�����������
//		���
//		model.setRowCount(0);//--�к�Ϊ0--�������
//		��ȡ��ͷ
//		JTableHeader header=table.getTableHeader();
//		�Ի���--��Ϣ��:JOptionPane
//		JOptionPane.showMessageDialog(null, "ss","��Ϣ��",JOptionPane.WARNING_MESSAGE);
//		ȷ�Ͽ�
//		JOptionPane.showConfirmDialog(null, "ȷ��?");//�з���ֵ
//		�����
//		JOptionPane.showInputDialog(null,"����������ʲô");
		
//		ѡ����ļ�--JFileChooser
		JFileChooser fc=new JFileChooser("d:/work");
		fc.showOpenDialog(null);//--�з���ֵ---����ͨ��IO����ȡ����
//		ѡ�񱣴��ļ�
		fc.showSaveDialog(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ��������
	}

}
