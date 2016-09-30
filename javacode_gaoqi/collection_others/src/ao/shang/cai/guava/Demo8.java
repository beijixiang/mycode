package ao.shang.cai.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;


import java.util.Map;
import java.util.Set;

/**
 * Table   两个key的map
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo8 {
    public static void main(String[] args) {

        Table<String, String, Integer> tables = HashBasedTable.create();
        //填入数据
        tables.put("a", "java", 90);
        tables.put("b", "java", 80);
        tables.put("a", "javaee", 100);
        tables.put("c", "javaee", 87);
//        遍历
        Set<Cell<String, String, Integer>> cells = tables.cellSet();
        for (Cell<String, String, Integer> cell : cells) {
            System.out.println(cell.getRowKey() + "--->" + cell.getColumnKey() + "--->" + cell.getValue());
        }

        System.out.println("====================以学生查看成绩=====================");
        System.out.print("学生\t");
        Set<String> cours = tables.columnKeySet();
        for (String temp : cours) {
            System.out.print(temp+"\t");
        }
        System.out.println();
        Set<String> stus = tables.rowKeySet();
        for (String stu : stus) {
            System.out.print(stu + "\t\t");
            Map<String, Integer> scores = tables.row(stu);
            for (String score : cours) {
                System.out.print(scores.get(score)+"\t\t");
            }

            System.out.println();
        }

        System.out.println("====================以课程查看成绩=====================");
        System.out.print("课程\t");

        Set<String> stus2 = tables.rowKeySet();
        for (String temp : stus2) {
            System.out.print(temp+"\t\t\t");
        }
        System.out.println();
        Set<String> cours2 = tables.columnKeySet();
        for (String stu : cours2) {
            System.out.print(stu + "\t\t");
            Map<String, Integer> scores = tables.column(stu);
            for (String stu2 : stus2) {
                System.out.print(scores.get(stu2)+"\t\t");
            }

            System.out.println();
        }

        System.out.println("=====================转换=====================");
        Table<String, String, Integer> tables2 = Tables.transpose(tables);
        Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
        for (Cell<String, String, Integer> cell : cells2) {
            System.out.println(cell.getRowKey() + "--->" + cell.getColumnKey() + "--->" + cell.getValue());
        }

    }
}
