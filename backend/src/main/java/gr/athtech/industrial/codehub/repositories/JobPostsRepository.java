package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.JobPosts;

import java.util.List;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 * @edit Panagiotis Kourempanas
 */
public interface JobPostsRepository extends PagingAndSortingRepository<JobPosts, Long> {

List<JobPosts> findJobPostsByJobTitle(String JobTitle);
List<JobPosts> findJobPostsByLocation(String location);
List<JobPosts> findJobPostsByQualifications(String qualifications);
List<JobPosts> findJobPostsByDateCreated(Date dateCreated);
List<JobPosts> findJobPostsByCompanyTitle(String CompanyTitle);
}
