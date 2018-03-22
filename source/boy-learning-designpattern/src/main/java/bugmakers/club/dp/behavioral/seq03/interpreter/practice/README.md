**练习**  
> Sunny软件公司欲为数据库备份和同步开发一套简单的数据库同步指令，通过指令可以对数据库中的数据和结构进行备份，例如，输入指令“COPY VIEW FROM srcDB TO desDB”表示将数据库srcDB中的所有视图(View)对象都拷贝至数据库desDB；输入指令“MOVE TABLE Student FROM srcDB TO desDB”表示将数据库srcDB中的Student表移动至数据库desDB。试使用解释器模式来设计并实现该数据库同步指令。


## 所有指令的文法规则

**demo**  
指令  
`up move 5 and down run 10 and left move 5`  
  
表达式
```
expression ::= value | operation
operation ::= expression '+' expression | expression '-'  expression
value ::= an integer //一个整数值
```

**demo-optimized**  
指令  
`LOOP 2 PRINT 杨过 SPACE SPACE PRINT 小龙女 BREAK END`  

表达式
```
expression ::= command* //表达式，一个表达式包含多条命令
command ::= loop | primitive //语句命令
loop ::= 'loop number' expression  'end' //循环命令，其中number为自然数
primitive ::= 'print string'  | 'space' | 'break' //基本命令，其中string为字符串
```

**practice**  
指令  
`COPY VIEW FROM srcDB TO desDB`  
`MOVE TABLE Student FROM srcDB TO desDB`  

表达式
```
expression ::= command* // 表达式，一个表达式包含多条命令
command ::= copy | move // 语句命令
copy ::= 'copy view from srcDB to desDB' // 复制命令，其中view是视图
move ::= 'move table tableName from srcDB to desDB' // 移动命令，其中table是数据表
```