<p>给你一个整数数组 <code>nums</code> 和两个整数 <code>indexDiff</code> 和 <code>valueDiff</code> 。</p>

<p>找出满足下述条件的下标对 <code>(i, j)</code>：</p>

<ul> 
 <li><code>i != j</code>,</li> 
 <li><code>abs(i - j) &lt;= indexDiff</code></li> 
 <li><code>abs(nums[i] - nums[j]) &lt;= valueDiff</code></li> 
</ul>

<p>如果存在，返回 <code>true</code><em> ；</em>否则，返回<em> </em><code>false</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
<strong>输出：</strong>true
<strong>解释：</strong>可以找出 (i, j) = (0, 3) 。
满足下述 3 个条件：
i != j --&gt; 0 != 3
abs(i - j) &lt;= indexDiff --&gt; abs(0 - 3) &lt;= 3
abs(nums[i] - nums[j]) &lt;= valueDiff --&gt; abs(1 - 1) &lt;= 0
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
<strong>输出：</strong>false
<strong>解释：</strong>尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= indexDiff &lt;= nums.length</code></li> 
 <li><code>0 &lt;= valueDiff &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>桶排序</li><li>有序集合</li><li>排序</li><li>滑动窗口</li></div></div><br><div><li>👍 736</li><li>👎 0</li></div>