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
class Solution:
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', '[.]')

#python
class Solution:
    def defangIPaddr(self, address: str) -> str:
        return '[.]'.join(address.split('.'))