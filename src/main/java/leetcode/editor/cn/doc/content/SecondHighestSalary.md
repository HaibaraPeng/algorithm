<code>Employee</code> 表：

<div class="original__bRMd"> 
 <div> 
  <pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
在 SQL 中，id 是这个表的主键。
表的每一行包含员工的工资信息。
</pre> 
 </div>
</div>

<p>&nbsp;</p>

<p>查询并返回 <code>Employee</code>&nbsp;表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 <code>null(Pandas 则返回 None)</code> 。</p>

<p>查询结果如下例所示。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
<strong>输出：</strong>
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
<strong>输出：</strong>
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+
</pre>


<div><div>Related Topics</div><div><li>数据库</li></div></div><br><div><li>👍 1480</li><li>👎 0</li></div>