<#import "../masterpage.ftl" as mp />
<@mp.page title="Show list">

  <h1>DESCRIPTION</h1>
  
	<#list order.getOrderedProduct() as orderProduct>
		<#if (orderProduct.quantity > 0)>
		${orderProduct.getProduct().name}
		${orderProduct.quantity}
		<#if (orderProduct.getOrder().finished?c) == "false">
			<button><a href="/order/remove/${orderProduct.id}">Delete</a></button>
		</#if>
		</#if>
	</#list>

</@mp.page>
