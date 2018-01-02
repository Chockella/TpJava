<#import "../masterpage.ftl" as mp />
<@mp.page title="Show list">

  <h1>PROFIL de ${account.firstName} ${account.lastName}</h1>
  <a href="/order/list">My orders</a>
  
	<form action="modification" method="post">
        First name:
        <input type="text" name="firstName" value="${account.firstName}">
        <br><br>
        Last name:
        <input type="text" name="lastName" value="${account.lastName}">
        <br><br>
        Address:
        <#if (account.address)??>
        	<input type="text" name="address" value="${account.address}">
        <#else>
        	<input type="text" name="address">
        </#if>
        <br><br>
        City:
        <#if (account.city)??>
        	<input type="text" name="city" value="${account.city}">
        <#else>
        	<input type="text" name="city">
        </#if>
        <br><br>
        Phone:
        <#if (account.phone)??>
        	<input type="text" name="phone" value="${account.phone}">
        <#else>
        	<input type="text" name="phone">
        </#if>
        <br><br>
        Zip Code:
        <#if (account.zip)??>
        	<input type="text" name="zip" value="${account.zip}">
        <#else>
        	<input type="text" name="zip">
        </#if>
        <br><br>
        <input type="submit" value="Change">
	</form>
  
</@mp.page>
