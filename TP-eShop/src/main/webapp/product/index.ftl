<#import "../masterpage.ftl" as mp />

<#assign css = "
<!-- test -->
">

<@mp.page title="Show list" css=css>
  <div class="row">
    <h1>Liste des Produits</h1>

    <table class="table table-striped table-hover">
      <thead class="thead-light">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Stock</th>
        <th scope="col">Price</th>
      </tr>
      </thead>
      <tbody>
      <#list products as product>
      	<#if (product.endOfLife?c) == "false">
	      <tr>
	        <th scope="row"><a href="/product/${product.id}">${product.name}</a></th>
	        <td>${product.quantity}</td>
	        <td>${product.price}</td>
	      </tr>
      	</#if>
      </#list>
      </tbody>
    </table>
  </div>
</@mp.page>
