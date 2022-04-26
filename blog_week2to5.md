# 一、结构化需求分析
## 1.1 功能分析
**系统目的**：建设建设北京理工大学数据中台，打造集数据采集、数据处理、监测管理、可视化于一体的数据中台。
**功能顶层**：教务管理、学生事务、校园论坛、校园检测。
**基本功能**：
- 教务管理：利用app平台，对接乐学、延河课堂等平台；对接教务管理中心课程表查看、考试安排查看等模块。
- 学生事务：利用app平台，对接请假销假、场地预约平台。
- 校园论坛：实现校内跳蚤市场功能，提供一个校园内部二手交易平台；实现线上论坛功能，提供一个校园互动平台；实现匿名树洞功能，提供一个匿名交流平台。
- 校园检测：提供检测页面，实现实时查看校园中个地点的最新人数的功能。

## 1.2 需求细化与优先级划分
![在这里插入图片描述](https://img-blog.csdnimg.cn/b970837b9f1746d9a9dad68b0a48b02d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5aSp5omN55yf54ix5pWZ5b6S,size_20,color_FFFFFF,t_70,g_se,x_16)
# 二、过程建模
## 2.1 DFD图
- 上下文图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/a35ffdb629374d34adc7837f32cf0c80.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5aSp5omN55yf54ix5pWZ5b6S,size_13,color_FFFFFF,t_70,g_se,x_16)
- 0层图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/f1a7f91d838a450cb30e2b4e3f470584.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5aSp5omN55yf54ix5pWZ5b6S,size_20,color_FFFFFF,t_70,g_se,x_16)

## 2.2 实体关系图（ERD）
![在这里插入图片描述](https://img-blog.csdnimg.cn/113545ee9b564b5f98dbde2d8c277939.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5aSp5omN55yf54ix5pWZ5b6S,size_13,color_FFFFFF,t_70,g_se,x_16)