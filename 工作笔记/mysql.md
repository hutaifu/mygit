在SQL中，当使用比较运算符（如=、<、>等）比较一个值时，如果其中一个值为null，那么比较的结果将会是未知（unknown），而不是true或false。因此，如果一个字段的值为null，那么它与任何值的比较结果都将是未知。在这种情况下，如果使用t1.is_changing != '2'来过滤数据，那么所有值为null的行都将被过滤掉，因为它们与'2'的比较结果都是未知。如果想要包含值为null的行，可以使用IS NULL或IS NOT NULL来检查字段是否为null，例如：

SELECT * FROM t1 WHERE is_changing IS NULL OR is_changing != '2';

这将返回所有is_changing字段值为null或不等于'2'的行。