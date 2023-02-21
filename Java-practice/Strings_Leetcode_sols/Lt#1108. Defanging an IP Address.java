//1108. Defanging an IP Address

//javascript
var defangIPaddr = function(address) {
    return address.split('.').join('[.]');
};

//java
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

#python

