package com.AddressService.demo.Service;

import com.AddressService.demo.Exceptions.AddressException;
import com.AddressService.demo.Model.Address;
import com.AddressService.demo.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address registerAddress(Address address) {

        return addressRepository.save(address);

    }

    @Override
    public Address updateAddress(Address address) {

        Address validatedAddress = addressRepository.findById(address.getAddressId()).orElseThrow(()-> new AddressException("Address not found with address id : "+address.getAddressId()));

        return addressRepository.save(address);

    }

    @Override
    public Address getAddress(Integer addressId) {

        return addressRepository.findById(addressId).orElseThrow(()-> new AddressException("Address does not exists with address id : "+addressId));

    }

    @Override
    public Address deleteAddressById(Integer addressId) {

        Address address = addressRepository.findById(addressId).orElseThrow(()-> new AddressException("Address does not exists with address id : "+addressId));

        addressRepository.delete(address);

        return address;

    }
}
