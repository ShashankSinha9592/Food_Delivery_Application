package com.AddressService.demo.Service;

import com.AddressService.demo.Model.Address;

public interface AddressService {

    public Address registerAddress(Address address);

    public Address updateAddress(Address address);

    public Address getAddress(Integer addressId);

    public Address deleteAddressById(Integer addressId);


}
