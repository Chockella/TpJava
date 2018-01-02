<#import "../masterpage.ftl" as mp />
<@mp.page title="Show list">

  <div class="row" style="display:block;">
    <h1>Description Produit '${product.name}'</h1>
    <p>
    <#if (product.description)??>
    	${product.description}
    <#else>
    	'Pas de description'
    </#if>
    </p>
    <p>${product.price}</p>
    <p>${product.quantity} left</p>
    
    <#if (product.quantity) == 0>
    	Désolé, mais ce produit n'est plus en stock
    <#elseif (account)??>
    	<button><a href="/order/add/${product.id}">Ajouter au panier</a></button>
    <#else>
    	Vous devez vous connecter
    </#if>
    
    <#if (order)??>
    	<p>${order.id}</p>
    </#if>
    
  </div>
</@mp.page>
