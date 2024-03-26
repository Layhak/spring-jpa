package co.istad.jbsdemo.springjba.dto;

import lombok.Builder;

@Builder
public record ProductRespone(Long id, String title, String description, String imageUrl, float price) {
}
