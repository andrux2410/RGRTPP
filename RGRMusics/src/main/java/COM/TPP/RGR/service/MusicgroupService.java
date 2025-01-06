package COM.TPP.RGR.service;

import COM.TPP.RGR.models.Musicgroup;
import COM.TPP.RGR.repository.MusicgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicgroupService {

    @Autowired
    private MusicgroupRepository musicgroupRepository;


    public List<Musicgroup> getAllMusicGroups() {
        return musicgroupRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }


    public Optional<Musicgroup> findMusicGroupById(int id) {
        return musicgroupRepository.findById(id);
    }


    public void saveMusicGroup(Musicgroup musicgroup) {
        musicgroupRepository.save(musicgroup);
    }


    public class MusicGroupHasGenreException extends RuntimeException {
        public MusicGroupHasGenreException(String message) {
            super(message);
        }
    }


    public void updateMusicGroup(Musicgroup updatedMusicGroup) {
        Musicgroup existingMusicGroup = musicgroupRepository.findById(updatedMusicGroup.getId())
                .orElseThrow(() -> new IllegalArgumentException("Music group not found"));

        existingMusicGroup.setGroupName(updatedMusicGroup.getGroupName());
        existingMusicGroup.setGenre(updatedMusicGroup.getGenre());
        existingMusicGroup.setYearofEstablished(updatedMusicGroup.getYearofEstablished());

        musicgroupRepository.save(existingMusicGroup);
    }


    public void deleteMusicGroup(int id) {
        musicgroupRepository.deleteById(id);
    }
}
