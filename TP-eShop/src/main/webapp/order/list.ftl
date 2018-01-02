<#import "../masterpage.ftl" as mp />
<@mp.page title="Show list">

  <h1>Liste des orders</h1>
  

  <#list orders as order>
  
  	<a href="/order/${order.id}">
  	<p>${order.createdAt}
  	<#if (order.total)??>
  	${order.total} euros
  	<#else>
  	</#if></p>
  	</a>
  </#list>
  
</@mp.page>
