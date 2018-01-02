<#import "../masterpage.ftl" as mp />
<@mp.page title="Show list">

  <form action="authentification" method="post">
            First name:<br>
            <input type="text" name="firstName">
            <br><br>
            Last name:<br>
            <input type="text" name="lastName">
            <br><br>
            <input type="submit" value="Submit">
        </form>
       
   <#if (error)??>
   		<p>${error}</p>
   </#if>
  
</@mp.page>
