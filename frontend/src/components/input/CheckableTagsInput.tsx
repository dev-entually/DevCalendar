import React, { useState } from 'react';
import { Button } from '../../components';
import { Code, CheckableTagsInputProps } from '../../model/components/input';
import styles from './CheckableTagsInput.module.css';

const removeAElementInArray = (elementToRemove: any, arr: any[]) => {
  const targetIdx = arr.indexOf(elementToRemove);
  if (targetIdx === -1) return arr;
  const removed = [...arr]
  removed.splice(targetIdx, 1);
  return removed;
};

const CheckableTagsInput: React.FC<CheckableTagsInputProps> = ({ options }) => {
  const [selected, setSelected] = useState<string[]>([]);

  const onToggle: React.MouseEventHandler<HTMLElement> = ({ currentTarget }) => {
    const alreadySelected = selected.includes(currentTarget.id);
    if (alreadySelected)
      setSelected(
        removeAElementInArray(currentTarget.id, selected));
    else
      setSelected(selected => [...selected, currentTarget.id]);
    currentTarget.classList.toggle('active');
  };

  return (
    <div className={`wrap ${styles.tags}`}>
      { options.map(option =>
        <Button
          className={styles.active}
          key={option.value}
          id={option.value}
          label={option.label}
          onClick={onToggle} />
      )}
    </div>
  );
};

export default CheckableTagsInput;